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

import com.codegoogle.tcpmon.bookmark.BookmarkManager;

/**
 * @author Sebastien Le Callonnec
 */
public class Main {

  public Configuration parseArgs(String[] args) {

    int i = 0;
    String arg;
    if (args.length == 0) {
      System.out.println("Usage: java -jar tcpmon.jar [-remotehost] [-remoteport] [-localport] [-autostart]");
      System.out.println("Starting tcpmon with defaults...");
    }

    Configuration configuration = new Configuration();

    while (i < args.length && args[i].startsWith("-")) {
      arg = args[i++];
      if (arg.equals("-localport")) {
        if (i < args.length) {
          configuration.setLocalPort(args[i++]);
        }
      } else if (arg.equals("-remotehost")) {
        if (i < args.length) {
          configuration.setRemoteHost(args[i++]);
        }
      }
      if (arg.equals("-autostart")) {
        configuration.setAutoStart(true);
      } else if (arg.equals("-remoteport")) {
        if (i < args.length) {
          configuration.setRemotePort(args[i++]);
        }
      }
    }

    return configuration;
  }

  public static void main(final String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        Configuration configuration = new Main().parseArgs(args);

        BookmarkManager bookmarkManager = new BookmarkManager(configuration.getBookmarkLocation());
        MainWindow mainWindow = new MainWindow(bookmarkManager, configuration);

        mainWindow.setVisible(true);
      }
    });
  }
}
