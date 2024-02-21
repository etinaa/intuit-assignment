# Future Improvements

## Business logic
1. Upload CSV file by REST POST method with multipart file.

## Database
1. Create table of events (date + place). Move data about birth and death to that table. (3d normal form)
2. Save dates (birth and death) like a date and not like 3 numbers
3. Optimize data formats (varchar(N)) for string values

## Data Types
1. Enum for Bats and Throws ('L', 'R')
2. Better JSON for response. Group "birth" and "death" fields in object inside main information about player.

## Ops
1. Custom Logback logging settings
2. Settings for metrics

## Testing
1. Mutation testing - Pitest
2. Dependency-check - CVE in libs
3. Load testing - Gatling
4. Fuzzing - JQF