@Library('shared_library') _

pipeline {
    agent any

    parameters {
        string(name: 'REPO_URL', defaultValue: 'https://github.com/zoro2024/sonar.installation.git', description: 'Git repository URL')
        string(name: 'BRANCH', defaultValue: 'main', description: 'Git branch to checkout')
    }

    stages {
        stage('Checkout from SCM') {
            steps {
                SCM(params.REPO_URL, params.BRANCH)
            }
        }

        stage('Download, Install Gitleaks and Run Scan') {
            steps {
                gitleak()
            }
        }
        stage('Install trivy and run License scan') {
            steps {
                trivylicensescanning(params.REPO_URL)
            }
        }
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'CredScanReport'
            archiveArtifacts artifacts: 'trivy-license-report.json'
            notification()
            cleanWs()
        }
    }
}
