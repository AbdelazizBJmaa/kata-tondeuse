## DESCRIPTION
The application was developped on
* java 21
* spring boot 3.3.5

## for DEPLOY APP with Docker
1- Create the package  
``mvn clean package``
2- Build the docker image  
'''docker build -t tondeuse-batch-app .'''
3- Deploy the Docker Image  
''' docker run -d --name tondeuse-batch tondeuse-batch-app
