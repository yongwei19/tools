package com.test.tools.entity;


public class DiffyEntity {
    protected String primaryIp;

    protected String primaryPort;

    protected String secondaryIp;

    protected String secondaryPort;

    protected String candidateIp;

    protected String candidatePort;

    protected String protocol;

    protected String serviceName;

    protected String proxyPort;

    protected String adminPort;

    protected String httpPort;

    protected String rootUrl;

    protected String email;

    protected String allowHttpSideEffects;

    protected String excludeHttpHeadersComparison;

    protected String commitDate;

    public String getPrimaryIp() {
        return primaryIp;
    }

    public void setPrimaryIp(String primaryIp) {
        this.primaryIp = primaryIp;
    }

    public String getPrimaryPort() {
        return primaryPort;
    }

    public void setPrimaryPort(String primaryPort) {
        this.primaryPort = primaryPort;
    }

    public String getSecondaryIp() {
        return secondaryIp;
    }

    public void setSecondaryIp(String secondaryIp) {
        this.secondaryIp = secondaryIp;
    }

    public String getSecondaryPort() {
        return secondaryPort;
    }

    public void setSecondaryPort(String secondaryPort) {
        this.secondaryPort = secondaryPort;
    }

    public String getCandidateIp() {
        return candidateIp;
    }

    public void setCandidateIp(String candidateIp) {
        this.candidateIp = candidateIp;
    }

    public String getCandidatePort() {
        return candidatePort;
    }

    public void setCandidatePort(String candidatePort) {
        this.candidatePort = candidatePort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getAdminPort() {
        return adminPort;
    }

    public void setAdminPort(String adminPort) {
        this.adminPort = adminPort;
    }

    public String getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(String httpPort) {
        this.httpPort = httpPort;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAllowHttpSideEffects() {
        return allowHttpSideEffects;
    }

    public void setAllowHttpSideEffects(String allowHttpSideEffects) {
        this.allowHttpSideEffects = allowHttpSideEffects;
    }

    public String getExcludeHttpHeadersComparison() {
        return excludeHttpHeadersComparison;
    }

    public void setExcludeHttpHeadersComparison(String excludeHttpHeadersComparison) {
        this.excludeHttpHeadersComparison = excludeHttpHeadersComparison;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    @Override
    public String toString() {
        return "DiffyEntity{" +
                "primaryIp='" + primaryIp + '\'' +
                ", primaryPort='" + primaryPort + '\'' +
                ", secondaryIp='" + secondaryIp + '\'' +
                ", secondaryPort='" + secondaryPort + '\'' +
                ", candidateIp='" + candidateIp + '\'' +
                ", candidatePort='" + candidatePort + '\'' +
                ", protocol='" + protocol + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", proxyPort='" + proxyPort + '\'' +
                ", adminPort='" + adminPort + '\'' +
                ", httpPort='" + httpPort + '\'' +
                ", rootUrl='" + rootUrl + '\'' +
                ", email='" + email + '\'' +
                ", allowHttpSideEffects='" + allowHttpSideEffects + '\'' +
                ", excludeHttpHeadersComparison='" + excludeHttpHeadersComparison + '\'' +
                ", commitDate=" + commitDate +
                '}';
    }
}