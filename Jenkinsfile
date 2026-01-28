pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML(target: [
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Automation Test Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'test-output/screenshots/*.png', allowEmptyArchive: true
        }
    }
}
