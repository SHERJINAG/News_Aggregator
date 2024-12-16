# News Aggregator
A web-based application that aggregates news articles based on user preferences. Users can enter a keyword (e.g., "technology," "sports") to fetch related news articles and view them in a card-based layout.

---
## Features
User input for news preferences (e.g., "technology," "health").
Dynamic display of news articles in responsive cards.
Backend integration with Java Servlet and News API (or a custom data source).

---
## Technologies
Frontend: HTML, CSS, JavaScript
Backend: Java (Servlets), Apache Tomcat
External API: NewsAPI (optional)

---
## Installation
Clone the repository:
git clone https://github.com/your-username/news-aggregator.git
cd news-aggregator
Set up Apache Tomcat:

Download and install Apache Tomcat.
Set the JAVA_HOME and CATALINA_HOME environment variables.
Deploy the app:

Copy the news directory into the webapps folder of your Tomcat installation:
C:\path\to\tomcat\webapps\news\
Compile the Java code:

Navigate to WEB-INF/classes and compile:

javac -classpath "C:\path\to\tomcat\lib\servlet-api.jar;path-to-your-libraries" -d . NewsAggregatorServlet.java
Start Tomcat:
Run startup.bat (Windows) or startup.sh (Linux/Mac) to start Tomcat.
Open your browser and go to http://localhost:8080/news.

---
## Folder Structure
news/
├── WEB-INF/
│   ├── classes/
│   │   └── NewsAggregatorServlet.class
│   ├── lib/
│   │   └── json.jar
│   └── web.xml
├── css/
│   └── news.css
└── index.html


---
## Troubleshooting
HTTP Status 500: Check server logs for errors and ensure all required libraries are in the correct paths.
ClassNotFoundException: Ensure that all libraries (e.g., json.jar) are in the WEB-INF/lib folder.

---
## License
MIT License

---
