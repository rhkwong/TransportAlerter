
import de.spinscale.dropwizard.jobs.JobConfiguration;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MainAppConfiguration extends Configuration implements JobConfiguration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    private String mySqlUserName;
    private String mySqlPassword;

    @Valid
    @NotNull
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory factory) {
        this.database = factory;
    }

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return database;
    }


    public String getMySqlUserName() {
        return mySqlUserName;
    }

    public void setMySqlUserName(String mysqlUserName) {
        this.mySqlUserName = mysqlUserName;
    }

    public String getMySqlPassword() {
        return mySqlPassword;
    }

    public void setMySqlPassword(String mysqlPassword) {
        this.mySqlPassword = mysqlPassword;
    }

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}