pipeline
{
    environment {

        registry = "gannaraladin/devops-test"

        registryCredential = "docker_hub"

        dockerImage = ''

    }

    agent any

    stages
    {

        stage("Git")
        {
            steps
            {
                echo "pulling ...";
                    git branch: "master",
                    url: "https://github.com/gannaralaeddine/Devops-Test";
            }
        }

        stage("Maven Clean")
        {
            steps
            {
                sh "mvn clean";
            }
        }

        stage("Maven Compile")
        {
            steps
            {
                sh "mvn compile";
            }
        }

        stage("SonarQube")
        {
            steps
            {
                echo "Hello Sonar"
                sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar";
            }
        }

        stage("JUnit / Mockito")
        {
            steps
            {
                echo "Hello JUnit"
                sh "mvn test"
            }
        }

        stage("Nexus")
        {
            steps
            {
                echo "Hello Nexus"
                sh "mvn deploy -DskipTests"
            }
        }

        stage('Building image') {

            steps {

                script {

                    dockerImage = docker.build registry + ":$BUILD_NUMBER"

                }

            }

        }

        stage('Deploy image') {

            steps {

                script {

                    docker.withRegistry( '', registryCredential ) {

                        dockerImage.push()

                    }

                }

            }

        }

        stage('Cleaning up') {

            steps {

                sh "docker rmi $registry:$BUILD_NUMBER"

            }

        }

    }
}
