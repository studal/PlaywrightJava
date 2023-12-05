# To run tests in selenium grid
SELENIUM_REMOTE_URL=http://localhost:4444 mvn test  

# To run Docker-standalone-chromium
docker run -d -p 4444:4444 --shm-size="2g" -e SE_NODE_GRID_URL="http://localhost:4444" -e SE_NODE_MAX_SESSIONS=10 -e SE_NODE_OVERRIDE_MAX_SESSIONS=true seleniarm/standalone-chromium:117.0

# Docker password to see video is "secret"


# If extent report is not visible properly on Jenkins
Go to Manage Jenkins -> Script Console and type into console the following commands:
System.clearProperty("hudson.model.DirectoryBrowserSupport.CSP");
System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-scripts; default-src 'self'; script-src * 'unsafe-eval'; img-src *; style-src * 'unsafe-inline'; font-src *");