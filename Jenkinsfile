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
					step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: 'target/site/cobertura/*.html', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
				}
			}
		}
    }
}
