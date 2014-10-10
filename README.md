# simpletaxcalculator Project
Simple Sales Tax Calculator

## Prerequisites
Maven:
```
http://maven.apache.org/plugins/maven-install-plugin/download.cgi
```

Git:
```
http://git-scm.com/downloads
```


## Getting Started
Clone this repository. Issue the following command from the location you want the project to be created. 
It will create a new directory called taxcalculator and will download the code into it.

```
git clone https://github.com/moroccan-dude/simpletaxcalculator
```

Navigate to the newly created directory simpletaxcalculator
```
cd simpletaxcalculator
```

Generate the eclipse artifacts by running (this will incidentally download all the dependencies):

```
mvn eclipse:clean eclipse:eclipse
```

You can now mount your project into eclipse. From eclipse:
``` 
file|import existing project into workspace
```

Compile and package the project, using the following command:

```
mvn clean package -Dmaven.test.skip=true
```

## Testing
```
mvn test
```