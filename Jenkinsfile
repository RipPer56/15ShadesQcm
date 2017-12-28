pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'jdk1.8.0_101'
    }
    stages {
        
        stage ('Build') {
            steps {
				bat 'mvn install'
            }
            post {
                success {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
		stage('cobrtr'){
			steps{
				bat 'mvn cobertura:cobertura'
			}
			post{
				success {
					coberturaReportFile  'target/cobertura/*.ser'
				}
			}
		}
    }
}
