package com.hangjiang;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
//        String wsdlString = "<wsdl:definitions xmlns:xsd=\\\"http://www.w3.org/2001/XMLSchema\\\" xmlns:wsdl=\\\"http://schemas.xmlsoap.org/wsdl/\\\" xmlns:tns=\\\"http://webservice.wechat.framework.trt.com/\\\" xmlns:soap=\\\"http://schemas.xmlsoap.org/wsdl/soap/\\\" xmlns:ns1=\\\"http://schemas.xmlsoap.org/soap/http\\\" name=\\\"WebChatPlayformServiceImplService\\\" targetNamespace=\\\"http://webservice.wechat.framework.trt.com/\\\">\\n<wsdl:types>\\n<xs:schema xmlns:xs=\\\"http://www.w3.org/2001/XMLSchema\\\" xmlns:tns=\\\"http://webservice.wechat.framework.trt.com/\\\" elementFormDefault=\\\"unqualified\\\" targetNamespace=\\\"http://webservice.wechat.framework.trt.com/\\\" version=\\\"1.0\\\">\\n<xs:element name=\\\"weChatAuth\\\" type=\\\"tns:weChatAuth\\\"/>\\n<xs:element name=\\\"weChatAuthResponse\\\" type=\\\"tns:weChatAuthResponse\\\"/>\\n<xs:element name=\\\"weChatSendMsg\\\" type=\\\"tns:weChatSendMsg\\\"/>\\n<xs:element name=\\\"weChatSendMsgResponse\\\" type=\\\"tns:weChatSendMsgResponse\\\"/>\\n<xs:complexType name=\\\"weChatAuth\\\">\\n<xs:sequence>\\n<xs:element minOccurs=\\\"0\\\" name=\\\"wxID\\\" type=\\\"xs:string\\\"/>\\n</xs:sequence>\\n</xs:complexType>\\n<xs:complexType name=\\\"weChatAuthResponse\\\">\\n<xs:sequence>\\n<xs:element minOccurs=\\\"0\\\" name=\\\"return\\\" type=\\\"xs:string\\\"/>\\n</xs:sequence>\\n</xs:complexType>\\n<xs:complexType name=\\\"weChatSendMsg\\\">\\n<xs:sequence>\\n<xs:element minOccurs=\\\"0\\\" name=\\\"wxID\\\" type=\\\"xs:string\\\"/>\\n<xs:element minOccurs=\\\"0\\\" name=\\\"recvXml\\\" type=\\\"xs:string\\\"/>\\n</xs:sequence>\\n</xs:complexType>\\n<xs:complexType name=\\\"weChatSendMsgResponse\\\">\\n<xs:sequence>\\n<xs:element minOccurs=\\\"0\\\" name=\\\"return\\\" type=\\\"xs:string\\\"/>\\n</xs:sequence>\\n</xs:complexType>\\n</xs:schema>\\n</wsdl:types>\\n<wsdl:message name=\\\"weChatAuth\\\">\\n<wsdl:part element=\\\"tns:weChatAuth\\\" name=\\\"parameters\\\"></wsdl:part>\\n</wsdl:message>\\n<wsdl:message name=\\\"weChatSendMsg\\\">\\n<wsdl:part element=\\\"tns:weChatSendMsg\\\" name=\\\"parameters\\\"></wsdl:part>\\n</wsdl:message>\\n<wsdl:message name=\\\"weChatSendMsgResponse\\\">\\n<wsdl:part element=\\\"tns:weChatSendMsgResponse\\\" name=\\\"parameters\\\"></wsdl:part>\\n</wsdl:message>\\n<wsdl:message name=\\\"weChatAuthResponse\\\">\\n<wsdl:part element=\\\"tns:weChatAuthResponse\\\" name=\\\"parameters\\\"></wsdl:part>\\n</wsdl:message>\\n<wsdl:portType name=\\\"WeChatPlayformService\\\">\\n<wsdl:operation name=\\\"weChatAuth\\\">\\n<wsdl:input message=\\\"tns:weChatAuth\\\" name=\\\"weChatAuth\\\"></wsdl:input>\\n<wsdl:output message=\\\"tns:weChatAuthResponse\\\" name=\\\"weChatAuthResponse\\\"></wsdl:output>\\n</wsdl:operation>\\n<wsdl:operation name=\\\"weChatSendMsg\\\">\\n<wsdl:input message=\\\"tns:weChatSendMsg\\\" name=\\\"weChatSendMsg\\\"></wsdl:input>\\n<wsdl:output message=\\\"tns:weChatSendMsgResponse\\\" name=\\\"weChatSendMsgResponse\\\"></wsdl:output>\\n</wsdl:operation>\\n</wsdl:portType>\\n<wsdl:binding name=\\\"WebChatPlayformServiceImplServiceSoapBinding\\\" type=\\\"tns:WeChatPlayformService\\\">\\n<soap:binding style=\\\"document\\\" transport=\\\"http://schemas.xmlsoap.org/soap/http\\\"/>\\n<wsdl:operation name=\\\"weChatAuth\\\">\\n<soap:operation soapAction=\\\"\\\" style=\\\"document\\\"/>\\n<wsdl:input name=\\\"weChatAuth\\\">\\n<soap:body use=\\\"literal\\\"/>\\n</wsdl:input>\\n<wsdl:output name=\\\"weChatAuthResponse\\\">\\n<soap:body use=\\\"literal\\\"/>\\n</wsdl:output>\\n</wsdl:operation>\\n<wsdl:operation name=\\\"weChatSendMsg\\\">\\n<soap:operation soapAction=\\\"\\\" style=\\\"document\\\"/>\\n<wsdl:input name=\\\"weChatSendMsg\\\">\\n<soap:body use=\\\"literal\\\"/>\\n</wsdl:input>\\n<wsdl:output name=\\\"weChatSendMsgResponse\\\">\\n<soap:body use=\\\"literal\\\"/>\\n</wsdl:output>\\n</wsdl:operation>\\n</wsdl:binding>\\n<wsdl:service name=\\\"WebChatPlayformServiceImplService\\\">\\n<wsdl:port binding=\\\"tns:WebChatPlayformServiceImplServiceSoapBinding\\\" name=\\\"WebChatPlayformServiceImplPort\\\">\\n<soap:address location=\\\"http://172.26.2.197:8080/WeChat/cxf/wechat:service\\\"/>\\n</wsdl:port>\\n</wsdl:service>\\n</wsdl:definitions>\\n";
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add(wsdlString);
//
//        SS_WsdlParser ss_wsdlParser = new SS_WsdlParser();
//
//        System.out.println(ss_wsdlParser.SS_GetMethodList(arrayList));
//
//        URL url = new URL("http://192.168.0.171:8080/ws/services/AddServices");
//        System.out.println(url.getHost() + " : " + url.getPort());
//
//        url = new URL("http://192.168.0.171/ws/services/AddServices");
//        System.out.println(url.getHost() + ":" + url.getPort());
//        System.out.println(url.getDefaultPort());

        Multimap<String,String> multiMap = ArrayListMultimap.create();
        multiMap.put("y","uuu");
        multiMap.put("y","iii");
        multiMap.put("u","999");

        Map<String,Collection<String>> map = multiMap.asMap();
        for(Map.Entry<String,Collection<String>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + JSON.toJSONString(entry.getValue()));
        }
    }
}
