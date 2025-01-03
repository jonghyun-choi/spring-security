# Spring security (SS)

## Main components in SS
### UserDetailsService
- interface;
- an object implementing the interface manages details about users
  - InMemoryUserDetailsManager

### PasswordEncoder

### AuthenticationProvider
- defines authentication logic

### AuthentiationFilter

### AuthenticationManager

### Security Context

## HTTP vs HTTPS

## Types of authentication
1. HTTP Basic
    ```
        curl --location 'http://localhost:8080/hello' \
        --header 'Authorization: Basic dXNlcjo4ZTA2MmZmYS1mOTg3LTRmNDEtOTUzZi01NTE1Nzk3ODhiNjM='   
    ```
2. 



