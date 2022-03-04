package com.test.tools.service;

import com.test.tools.dao.DiffyDao;
import com.test.tools.entity.DiffyEntity;
import com.test.tools.tool.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DiffyService {

    @Autowired
    private DiffyDao diffyDao;

    // 将记录保存到数据库中
    public int addCommitLog(DiffyEntity diffyEntity){
        TimeTools t = new TimeTools();
        diffyEntity.setCommitDate(t.getTimeNow());
        return diffyDao.addCommitLog(diffyEntity);
    }


    public String getStartCommand(){
        DiffyEntity d = diffyDao.getCommandParam();
        String startCommand ="java -jar diffy-server.jar "
                + "-candidate='" + d.getCandidateIp() + ":" + d.getCandidatePort() + "' "
                + "-master.primary='" + d.getPrimaryIp() + ":" + d.getPrimaryPort() + "' "
                + "-master.secondary='" + d.getSecondaryIp() + ":" + d.getSecondaryPort() + "' "
                + "-service.protocol='" + d.getProtocol() + "' "
                + "-serviceName='" + d.getServiceName() + "' "
                + "-proxy.port=:" + d.getProxyPort() + " "
                + "-admin.port=:" + d.getAdminPort() + " "
                + "-http.port=:" + d.getHttpPort() + " "
                + "-rootUrl='" + d.getRootUrl() + "' "
                + "-summary.email='" + d.getEmail() + "' "
                + "-allowHttpSideEffects=" + d.getAllowHttpSideEffects() + " "
                + "-excludeHttpHeadersComparison=" + d.getExcludeHttpHeadersComparison() + " ";
        System.out.println(startCommand);
        return startCommand;
    }

}
