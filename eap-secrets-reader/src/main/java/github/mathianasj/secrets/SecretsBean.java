package github.mathianasj.secrets;

import javax.ejb.Stateful;
import javax.annotation.Resource;

@Stateful
public class SecretsBean {
    public String getPassword() {
        return System.getProperty("super.secret");
    }
}