# 1. Use base image with Maven + JDK 17
FROM maven:3.9.8-eclipse-temurin-17

# 2. Install Google Chrome
RUN apt-get update && apt-get install -y wget gnupg unzip \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# 3. Set working directory
WORKDIR /app

# 4. Copy project files
COPY . .

# 5. Run Maven build
RUN mvn clean install -DskipTests

# 6. Run tests by default
CMD ["mvn", "clean", "test"]
