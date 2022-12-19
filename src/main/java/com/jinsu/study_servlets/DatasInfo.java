package com.jinsu.study_servlets;

import java.util.ArrayList;
import java.util.HashMap;

import com.jinsu.study_servlets.beans.MemberBean;

public class DatasInfo {
    public HashMap<String, String> getSearchFormhData() {
        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "진수");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    public ArrayList<String> getTablesListData() {
        ArrayList<String> tablesListWithString = new ArrayList<String>();
        tablesListWithString.add("@mdo");
        tablesListWithString.add("@fat");
        tablesListWithString.add("@twitter");
        return tablesListWithString;
    }

    public HashMap<String, Object> getBundlesData() { // 이넘 하나만 부르면 모든 데이터를 사용가능
        HashMap<String, String> searchForm = getSearchFormhData();
        ArrayList<String> tablesListWithString = getTablesListData();

        HashMap<String, Object> bundlesData = new HashMap<>();
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListWithString", tablesListWithString);

        bundlesData.put("dataWithMemberBean", getDataWithMemberBean());
        bundlesData.put("dataListWithMemberBean", getDataListWithMemberBean());
        return bundlesData;
    }

    public MemberBean getDataWithMemberBean() {
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("Otto");
        memberBean.setHandleName("@mdo");
        return memberBean;
    }

    public ArrayList<MemberBean> getDataListWithMemberBean() {
        ArrayList<MemberBean> membersList = new ArrayList<>();
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("Otto");
        memberBean.setHandleName("@mdo");
        membersList.add(memberBean);

        MemberBean memberBean02 = new MemberBean();
        memberBean02.setFirstName("Jacob");
        memberBean02.setSecondName("Thornton");
        memberBean02.setHandleName("@fat");
        membersList.add(memberBean02);

        MemberBean memberBean03 = new MemberBean();
        memberBean03.setFirstName("Larry");
        memberBean03.setSecondName("Bird");
        memberBean03.setHandleName("@twitter");
        membersList.add(memberBean03);

        return membersList;
    }
}
