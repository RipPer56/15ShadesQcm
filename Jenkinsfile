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
			bat 'mvn cobertura:cobertura -Dcobertura.report.format=xml'
		}
		post{
			success {
				step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: 'target/site/cobertura/*.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
			}
		}
	}
	stage('jvdoc'){
		steps{
			bat 'mvn javadoc:javadoc'
		}
		post{
			success {
				step([$class: 'JavadocArchiver', javadocDir: 'target/site/apidocs', keepAll: false])
			}
		}
	}
	stage('package'){
		steps{
			bat 'mvn package'
		}
		
	}
	    stage('lekher'){
		    steps {
		      nexusArtifactUploader {
			nexusVersion('nexus2')
			protocol('http')
			nexusUrl('localhost:8080/nexus')
			groupId('sp.sd')
			version('2.4')
			repository('NexusArtifactUploader')
			credentialsId('44620c50-1589-4617-a677-7563985e46e1')
			artifact {
			    artifactId('nexus-artifact-uploader')
			    type('jar')
			    classifier('debug')
			    file('nexus-artifact-uploader.jar')
			}
			artifact {
			    artifactId('nexus-artifact-uploader')
			    type('hpi')
			    classifier('debug')
			    file('nexus-artifact-uploader.hpi')
			}
      		}
   	}
	    }
    }
}
