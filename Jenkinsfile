pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                // Clonar el repositorio de Git
                git branch: 'main', url: 'https://github.com/jhonny1997str/JenkinsJava.git'
            }
        }

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
                bat 'mvn test' // Cambiado a 'bat' para Windows
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Baja cualquier contenedor en ejecución para evitar conflictos
                    bat 'docker-compose down' // Cambiado a 'bat' para Windows

                    // Levanta la aplicación
                    bat 'docker-compose up -d' // Cambiado a 'bat' para Windows

                    // Esperar un poco para asegurarse de que el contenedor esté completamente levantado
                    sleep 10

                    // Verificar que el contenedor esté en ejecución
                    bat 'docker ps' // Cambiado a 'bat' para Windows
                }
            }
        }
    }
}
