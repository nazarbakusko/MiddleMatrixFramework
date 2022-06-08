FROM maven:3.8.1-jdk-11

# copying source of my framework
COPY src C:/Users/nazarii.bakusko/IdeaProjects/MiddleMatrixFramework/src

# copying pom.xml of my framework
COPY pom.xml C:/Users/nazarii.bakusko/IdeaProjects/MiddleMatrixFramework

# copying testng.xml of my framework
COPY src/test/java/testng.xml C:/Users/nazarii.bakusko/IdeaProjects/MiddleMatrixFramework

# running the actual command
RUN mvn -f C:/Users/nazarii.bakusko/IdeaProjects/MiddleMatrixFramework/pom.xml clean test -DskipTests=true