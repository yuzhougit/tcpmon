/*
 * Copyright (c) 2011 Sebastien Le Callonnec.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.codegoogle.tcpmon;

/**
 * @author Sebastien Le Callonnec
 */
public class Configuration {
  public final static String DEFAULT_LOCAL_PORT = "8080";
  public final static String DEFAULT_REMOTE_HOST = "127.0.0.1";
  public final static String DEFAULT_REMOTE_PORT = "80";

  private String localPort = DEFAULT_LOCAL_PORT;
  private String remoteHost = DEFAULT_REMOTE_HOST;
  private String remotePort = DEFAULT_REMOTE_PORT;
  private boolean autoStart;

  public String getLocalPort() {
    return localPort;
  }

  public void setLocalPort(String localPort) {
    this.localPort = localPort;
  }

  public String getRemoteHost() {
    return remoteHost;
  }

  public void setRemoteHost(String remoteHost) {
    this.remoteHost = remoteHost;
  }

  public String getRemotePort() {
    return remotePort;
  }

  public void setRemotePort(String remotePort) {
    this.remotePort = remotePort;
  }

  public boolean isAutoStart() {
    return autoStart;
  }

  public void setAutoStart(boolean autoStart) {
    this.autoStart = autoStart;
  }
}
