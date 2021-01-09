//package restapi.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    JwtConfigurer jwtConfigurer;
//
//    private final CorsFilter corsFilter;
//
//    @Autowired
//    public WebSecurityConfig(@Lazy CorsFilter corsFilter, JwtConfigurer configurer) {
//        this.corsFilter = corsFilter;
//        this.jwtConfigurer = configurer;
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @SuppressWarnings("deprecation")
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //@formatter:off
//        http
//                .cors()
//                .and()
//                .httpBasic().disable()
//                //csrf might need to be enabled for websocket security to work
//                .csrf()
////                .ignoringAntMatchers("/login", "/**")
//                .ignoringAntMatchers("/login", "/account", "/join/**")
//                .ignoringAntMatchers("/register")
//                .and()
//                .headers()
//                .frameOptions().sameOrigin()
//                .and()
////                .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/account").authenticated()
//                .antMatchers(HttpMethod.POST, "/account").permitAll()
//                .antMatchers(HttpMethod.PUT, "/account").authenticated()
//                .antMatchers(HttpMethod.GET, "/account").authenticated()
//                .antMatchers(HttpMethod.GET, "/account/{id}").authenticated()
//                .antMatchers(HttpMethod.GET, "/leaderboard").authenticated()
//                .antMatchers(HttpMethod.POST, "/leaderboard").authenticated()
//                .antMatchers(HttpMethod.PUT, "/leaderboard").authenticated()
//                .antMatchers(HttpMethod.GET, "/csrf").permitAll()
//                .antMatchers("/start").authenticated()
//                .antMatchers("/topic/**").permitAll()
//                .antMatchers("/app/**").permitAll()
//                //.anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .usernameParameter("name")
//                .passwordParameter("password")
//                .loginProcessingUrl("/authenticate")
//                .and()
//                .apply(this.jwtConfigurer);
//        //@formatter:on
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        System.out.println("[CUSTOM CORS]: Adding cors filter");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
////        config.setAllowedOrigins(Arrays.asList("*"));
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:4200");
//        config.addAllowedOrigin("https://blokkus.beekmans.dev");
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("OPTIONS");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("DELETE");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}
//
