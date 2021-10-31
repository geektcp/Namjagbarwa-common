/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.message;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import static org.apache.kafka.common.message.ApiVersionsRequestData.*;

public class ApiVersionsRequestDataJsonConverter {
    public static ApiVersionsRequestData read(JsonNode _node, short _version) {
        ApiVersionsRequestData _object = new ApiVersionsRequestData();
        JsonNode _clientSoftwareNameNode = _node.get("clientSoftwareName");
        if (_clientSoftwareNameNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("ApiVersionsRequestData: unable to locate field 'clientSoftwareName', which is mandatory in version " + _version);
            } else {
                _object.clientSoftwareName = "";
            }
        } else {
            if (!_clientSoftwareNameNode.isTextual()) {
                throw new RuntimeException("ApiVersionsRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.clientSoftwareName = _clientSoftwareNameNode.asText();
        }
        JsonNode _clientSoftwareVersionNode = _node.get("clientSoftwareVersion");
        if (_clientSoftwareVersionNode == null) {
            if (_version >= 3) {
                throw new RuntimeException("ApiVersionsRequestData: unable to locate field 'clientSoftwareVersion', which is mandatory in version " + _version);
            } else {
                _object.clientSoftwareVersion = "";
            }
        } else {
            if (!_clientSoftwareVersionNode.isTextual()) {
                throw new RuntimeException("ApiVersionsRequestData expected a string type, but got " + _node.getNodeType());
            }
            _object.clientSoftwareVersion = _clientSoftwareVersionNode.asText();
        }
        return _object;
    }
    public static JsonNode write(ApiVersionsRequestData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        if (_version >= 3) {
            _node.set("clientSoftwareName", new TextNode(_object.clientSoftwareName));
        }
        if (_version >= 3) {
            _node.set("clientSoftwareVersion", new TextNode(_object.clientSoftwareVersion));
        }
        return _node;
    }
    public static JsonNode write(ApiVersionsRequestData _object, short _version) {
        return write(_object, _version, true);
    }
}
