pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'jdk1.8.0_101'
    }
    stages {
	    stage('lekher'){
		    steps{
			    nexusPublisher nexusInstanceId: 'nexus',
				    nexusRepositoryId: 'releases',
				    packages: [[$class: 'MavenPackage',
						mavenAssetList: [[classifier: '',
								  extension: 'jar',
								  filePath: 'target/15ShadesQcm-0.0.1-SNAPSHOT.jar']],
						mavenCoordinate: [artifactId: '15ShadesQcm',
								  groupId: 'com.fboot',
								  packaging: 'jar',
								  version: '0.0.1-SNAPSHOT']
					       ]]
		    }
	    }
     }
}
