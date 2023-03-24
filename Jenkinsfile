def project = "API Automation with REST Assured"
pipeline{
    agent any
    parameters{
        string(name: "Repositories", defaultValue: "", trim: true, description: "Please enter your Repositories")
        string(name: "TestCases", defaultValue: "", trim: true, description: "Please enter the desired tags")
    }
    stages{
        stage('Build'){
            steps{
                echo 'Hi, i am going to do testing!'
            }
        }
        stage('Testing'){
            steps{
                git "$params.Repositories"
                script{
                    bat """
                    mvn clean test -Dgroups=$TestCases
                    """
                    }
            }
        }
        stage('Publish Report'){
            steps{
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
}