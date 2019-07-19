/**
 * ZMMWS_MOVSERIES_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package functions.rfc.sap.document.sap_com;

public class ZMMWS_MOVSERIES_ServiceLocator extends org.apache.axis.client.Service implements functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_Service {

    public ZMMWS_MOVSERIES_ServiceLocator() {
    }


    public ZMMWS_MOVSERIES_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ZMMWS_MOVSERIES_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ZMMBN_MOVSERIES
    private java.lang.String ZMMBN_MOVSERIES_address = "http://prosapfi.sistemasbo.corp:8000/sap/bc/srt/rfc/sap/zmmws_movseries/800/zmmws_movseries/zmmbn_movseries";

    public java.lang.String getZMMBN_MOVSERIESAddress() {
        return ZMMBN_MOVSERIES_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ZMMBN_MOVSERIESWSDDServiceName = "ZMMBN_MOVSERIES";

    public java.lang.String getZMMBN_MOVSERIESWSDDServiceName() {
        return ZMMBN_MOVSERIESWSDDServiceName;
    }

    public void setZMMBN_MOVSERIESWSDDServiceName(java.lang.String name) {
        ZMMBN_MOVSERIESWSDDServiceName = name;
    }

    public functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_PortType getZMMBN_MOVSERIES() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ZMMBN_MOVSERIES_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getZMMBN_MOVSERIES(endpoint);
    }

    public functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_PortType getZMMBN_MOVSERIES(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            functions.rfc.sap.document.sap_com.ZMMBN_MOVSERIESStub _stub = new functions.rfc.sap.document.sap_com.ZMMBN_MOVSERIESStub(portAddress, this);
            _stub.setPortName(getZMMBN_MOVSERIESWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setZMMBN_MOVSERIESEndpointAddress(java.lang.String address) {
        ZMMBN_MOVSERIES_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                functions.rfc.sap.document.sap_com.ZMMBN_MOVSERIESStub _stub = new functions.rfc.sap.document.sap_com.ZMMBN_MOVSERIESStub(new java.net.URL(ZMMBN_MOVSERIES_address), this);
                _stub.setPortName(getZMMBN_MOVSERIESWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ZMMBN_MOVSERIES".equals(inputPortName)) {
            return getZMMBN_MOVSERIES();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZMMWS_MOVSERIES");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "ZMMBN_MOVSERIES"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ZMMBN_MOVSERIES".equals(portName)) {
            setZMMBN_MOVSERIESEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
