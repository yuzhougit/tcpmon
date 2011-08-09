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
package com.codegoogle.tcpmon.bookmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastien Le Callonnec
 */
public class BookmarkManager {
  private String bookmarkFile;
  
  public BookmarkManager(String bookmarkFile) {
    this.bookmarkFile = bookmarkFile;
  }

  public List<Bookmark> list() {
    List<Bookmark> bookmarks = new ArrayList<Bookmark>();
    try {
       BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(bookmarkFile)));
       String currentLine;
       while ((currentLine = bufferedReader.readLine()) != null) {
         String[] values = currentLine.split("\\|");
         
         Bookmark bookmark = new Bookmark(values[0], values[1], values[2], values[3], Boolean.valueOf(values[4]));
         bookmarks.add(bookmark);
       }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return bookmarks;
  }
}
