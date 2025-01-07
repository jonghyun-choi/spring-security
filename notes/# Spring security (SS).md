# Spring security (SS)

## User Management components
- UserDetails
  - describe user
- UserDetailsService
  - get user by username
- UserDetailsManager extends UserDetailService
  - adds functionality ['Add', 'Modify', 'Delete'] to UserDetailsService
  - Sample impls
    - InMemoryUserDetailsManager
    - JdbcUserDetailsManager
    - LdapUserDetailsManager
- GrantedAuthority
  - What user can do
  - Sample impls
    - SimpleGrantedAuthority

1. UserDetails has one or more GrantedAuthority
2. UserDetailsService uses UserDetails

## Define user
```java
public interface UserDetails extends Serializable {
  String getUsername();
  String getPassword();
  Collection <? extends GrantedAuthority> getAuthorities();
  boolean isAccountNonExpired();
  boolean isAccountNonLocked();
  boolean isCredentialsNonExpired();
  boolean isEnabled();

  // if unwanted default is; () -> {return true;}
}

public interface GrantedAuthority extends Serializable {
  String getAuthority();
  // GrantedAutority g1 = () -> "READ"; lambda single abstract method feature
  // GrantedAuthority g2 = new SimpleGrantedAuthority("READ");
}

```


### AuthenticationProvider
### AuthentiationFilter
### AuthenticationManager
### Security Context
## HTTP vs HTTPS

## Authentication Types
1. HTTP Basic
    ```
        curl --location 'http://localhost:8080/hello' \
        --header 'Authorization: Basic dXNlcjo4ZTA2MmZmYS1mOTg3LTRmNDEtOTUzZi01NTE1Nzk3ODhiNjM='   
    ```
2. 



