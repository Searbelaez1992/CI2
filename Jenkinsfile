pipeline {
    agent {label 'slave'}

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Apache_Maven"
    }

    stages {
        
        stage('Checkout Code') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/Searbelaez1992/CI2.git', branch: "main"

            }
        }
        
                stage('Static Code Analysis') {
            steps {
                sh "mvn checkstyle:checkstyle"
            }
        }
        
                stage('Publish Static Code Analysis Reports') {
            steps {
                recordIssues sourceCodeRetention: 'LAST_BUILD', tools: [checkStyle(pattern: 'reports/checkstyle/checkstyle.xml')]
            }
        }
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git url: 'https://github.com/Searbelaez1992/CI2.git', branch: "main"

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}
