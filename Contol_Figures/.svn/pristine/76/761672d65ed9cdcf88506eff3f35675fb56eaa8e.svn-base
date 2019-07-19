package functions.rfc.sap.document.sap_com;

public class ZMMWS_MOVSERIESProxy implements functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_PortType {
  private String _endpoint = null;
  private functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_PortType zMMWS_MOVSERIES_PortType = null;
  
  public ZMMWS_MOVSERIESProxy() {
    _initZMMWS_MOVSERIESProxy();
  }
  
  public ZMMWS_MOVSERIESProxy(String endpoint) {
    _endpoint = endpoint;
    _initZMMWS_MOVSERIESProxy();
  }
  
  private void _initZMMWS_MOVSERIESProxy() {
    try {
      zMMWS_MOVSERIES_PortType = (new functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_ServiceLocator()).getZMMBN_MOVSERIES();
      if (zMMWS_MOVSERIES_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)zMMWS_MOVSERIES_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)zMMWS_MOVSERIES_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (zMMWS_MOVSERIES_PortType != null)
      ((javax.xml.rpc.Stub)zMMWS_MOVSERIES_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public functions.rfc.sap.document.sap_com.ZMMWS_MOVSERIES_PortType getZMMWS_MOVSERIES_PortType() {
    if (zMMWS_MOVSERIES_PortType == null)
      _initZMMWS_MOVSERIESProxy();
    return zMMWS_MOVSERIES_PortType;
  }
  
  public void ZMMMF_MOVSERIES(java.lang.String FECHA_1, java.lang.String FECHA_2, javax.xml.rpc.holders.StringHolder MENSAJE, functions.rfc.sap.document.sap_com.holders.ZMMTT_MOVGERNRHolder SERIES) throws java.rmi.RemoteException{
    if (zMMWS_MOVSERIES_PortType == null)
      _initZMMWS_MOVSERIESProxy();
    zMMWS_MOVSERIES_PortType.ZMMMF_MOVSERIES(FECHA_1, FECHA_2, MENSAJE, SERIES);
  }
  
  
}