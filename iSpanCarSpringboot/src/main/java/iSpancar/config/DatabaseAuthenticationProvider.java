package iSpancar.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class DatabaseAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		  String username = authentication.getName();
	        String password = authentication.getCredentials().toString();

	        // 檢查用戶名和密碼是否正確，這裡可以連接數據庫來獲取用戶資訊
	        if (!username.equals("user") || !password.equals("password")) {
	            throw new BadCredentialsException("Invalid username or password");
	        }

	        // 為用戶分配權限
	        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

	        // 返回一個已認證的UsernamePasswordAuthenticationToken
	        return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
