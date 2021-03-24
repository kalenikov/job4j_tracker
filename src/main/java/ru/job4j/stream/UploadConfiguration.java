package ru.job4j.stream;

public class UploadConfiguration {
    private String host;
    private Integer port;
    private String charset;
    private String delimiter;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "UploadConfiguration{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", charset='" + charset + '\'' +
                ", delimiter='" + delimiter + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    static class Builder {
        private String host;
        private Integer port;
        private String charset;
        private String delimiter;
        private String login;
        private String password;

        Builder buildHost(String host) {
            this.host = host;
            return this;
        }

        Builder buildPort(Integer port) {
            this.port = port;
            return this;
        }

        Builder buildCharset(String charset) {
            this.charset = charset;
            return this;
        }

        Builder buildDelimiter(String delimiter) {
            this.login = delimiter;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        UploadConfiguration build() {
            UploadConfiguration conf = new UploadConfiguration();
            conf.host = host;
            conf.port = port;
            conf.delimiter = delimiter;
            conf.charset = charset;
            conf.login = login;
            conf.password = password;
            return conf;
        }
    }


    public static void main(String[] args) {
        UploadConfiguration conf = new Builder().buildHost("localhost")
                .buildPort(21)
                .buildCharset("UTF-8")
                .buildLogin("demo")
                .buildDelimiter("\\t")
                .build();
        System.out.println(conf);

    }

}
