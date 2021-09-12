//package com.p5.adoptions.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final MyUserDetailService userDetailsService;
//    private final BCryptPasswordEncoder passwordEncoder;
//    private final DataSource dataSource;
//
//    public WebSecurityConfig(MyUserDetailService userDetailsService, BCryptPasswordEncoder passwordEncoder, DataSource dataSource) {
//        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
//        this.dataSource = dataSource;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.authorizeRequests()
//                .antMatchers("/v1/animals/hello").permitAll()
////                .antMatchers("/v1/shelters/*").hasRole("USER")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and().csrf().disable();
////                .permitAll();
////        http.csrf().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder)
//                .and()
//                .authenticationProvider(authenticationProvider())
//                .jdbcAuthentication()
//                .dataSource(dataSource);
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider()
//    {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//        return daoAuthenticationProvider;
//    }
//
////        After we have implemented UserDetailsService, we don't need this hack anymore.
////        @Bean
////        @Override
////        protected UserDetailsService userDetailsService()
////        {
////            UserDetails user = User.withDefaultPasswordEncoder()
////                                   .username("user")
////                                   .password("password")
////                                   .roles("USER")
////                                   .build();
////            return new InMemoryUserDetailsManager(user);
////        }
//}
