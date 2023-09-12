import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 允许跨域请求的源，这里设置为前端应用的地址
        config.addAllowedOrigin("http://localhost:80");

        // 允许发送认证信息（cookies、HTTP认证以及客户端SSL证明等）
        config.setAllowCredentials(true);

        // 允许的请求头
        config.addAllowedHeader("*");

        // 允许的HTTP请求方法
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
