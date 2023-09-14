package github.mathianasj.secrets;

import javax.ejb.Stateful;
import javax.annotation.Resource;

@Stateful
public class SecretsBean {
    @Resource(name="myEnvEntry")
    private String password;

    public String getPassword() {
        return System.getProperty("super.secret");
    }

    public void setPassword(String password) {
        System.out.println("setting password");
        this.password = password;
    }
}