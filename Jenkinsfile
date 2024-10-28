pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Construir la imagen Docker usando el Dockerfile
                    docker.build("demo-app", "-f Dockerfile .")
                }
            }
        }

        stage('Test') {
            steps {
                // Ejecutar pruebas con Maven
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Baja cualquier contenedor en ejecución para evitar conflictos
                    sh 'docker-compose down'

                    // Levanta la aplicación
                    sh 'docker-compose up -d'

                    // Esperar un poco para asegurarse de que el contenedor esté completamente levantado
                    sleep 10

                    // Verificar que el contenedor esté en ejecución
                    sh 'docker ps'
                }
            }
        }
    }
}
