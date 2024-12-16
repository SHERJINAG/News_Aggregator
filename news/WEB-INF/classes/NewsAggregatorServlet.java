import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.json.*;

public class NewsAggregatorServlet extends HttpServlet {
    
    private static final String API_KEY = "bd255551b34442f9b040a94b0ea2f744"; // Replace with your NewsAPI key
    private static final String BASE_URL = "https://newsapi.org/v2/top-headlines?country=us&apiKey=" + API_KEY;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Get user preference from request
        String preference = request.getParameter("preference");
        if (preference == null) {
            preference = "general"; // Default preference if none provided
        }

        // Fetch the news based on the user's preference
        try {
            List<String> news = fetchNews(preference);
            out.println("<html><body>");
            out.println("<h2>Top News Articles based on your preference: " + preference + "</h2>");
            
            if (news.size() > 0) {
                out.println("<ul>");
                for (String article : news) {
                    out.println("<li>" + article + "</li>");
                }
                out.println("</ul>");
            } else {
                out.println("<p>No news found for the given preference.</p>");
            }
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<p>Error fetching news: " + e.getMessage() + "</p>");
        }
    }

    private List<String> fetchNews(String preference) throws Exception {
        String urlString = BASE_URL + "&q=" + URLEncoder.encode(preference, "UTF-8");
        URL url = new URL(urlString);
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        
        JSONObject myResponse = new JSONObject(response.toString());
        JSONArray articles = myResponse.getJSONArray("articles");
        
        List<String> newsList = new ArrayList<>();
        
        for (int i = 0; i < articles.length(); i++) {
            JSONObject article = articles.getJSONObject(i);
            String title = article.getString("title");
            String description = article.optString("description", "No description available");
            newsList.add(title + " - " + description);
        }
        
        return newsList;
    }
}
