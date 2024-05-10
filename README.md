IntelliJ IDEA
## Starting the service
1. SDK 17.0.3. Maven 4.0.0.
2. Download the project's source code or clone the repository to your local directory.
   
```bash
git clone
```

3. Go to the root directory of the project.

```bash
cd <org/example/whoscared>
```

4. Build the project using Maven.
   Maven->Lifecycles

```bash
mvn clean 
```
```bash
mvn package
```

5. Build docker images

```bash
docker build -t my-app .
```
```bash
docker build -t my-bd .
```
The commands must be called in the directory with the current dockerfiles

6. Run doker container 
```bash
docker run -d -p 8080:8080 my-app 
```
```bash
docker run -d -p 5555:5432 my-bd 
```

