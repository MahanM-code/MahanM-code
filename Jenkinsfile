pipeline {
    agent any

    environment {
        IMAGE_NAME = "testng-app"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                bat '''
                docker build -t %IMAGE_NAME% .
                '''
            }
        }

        stage('Run Tests in Docker') {
            steps {
        bat '''
        docker run --rm ^
        -v "%WORKSPACE%\\target:/app/target" ^
        -v "%WORKSPACE%\\test-output:/app/test-output" ^
        testng-app
        '''
    }
        }
    }

    post {
        always {

            // Archive raw test results (optional but useful)
            archiveArtifacts artifacts: 'target/**/*.xml', fingerprint: true

            // Publish TestNG HTML Report
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'test-output',
                reportFiles: 'index.html',
                reportName: 'TestNG Automation Report'
            ])
        }
    }
}
