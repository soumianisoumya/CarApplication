node {
       def mvn_version = 'mvn1' 
        stage('download repo') { 

        git 'https://github.com/soumianisoumya/MVC.git' 

        withEnv( ["PATH+MAVEN=${tool mvn_version}/bin"] ) { 

        sh "mvn clean install" 

    } 
        }
}
