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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ShortNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.kafka.common.protocol.MessageUtil;

import static org.apache.kafka.common.message.DescribeClusterResponseData.*;

public class DescribeClusterResponseDataJsonConverter {
    public static DescribeClusterResponseData read(JsonNode _node, short _version) {
        DescribeClusterResponseData _object = new DescribeClusterResponseData();
        JsonNode _throttleTimeMsNode = _node.get("throttleTimeMs");
        if (_throttleTimeMsNode == null) {
            throw new RuntimeException("DescribeClusterResponseData: unable to locate field 'throttleTimeMs', which is mandatory in version " + _version);
        } else {
            _object.throttleTimeMs = MessageUtil.jsonNodeToInt(_throttleTimeMsNode, "DescribeClusterResponseData");
        }
        JsonNode _errorCodeNode = _node.get("errorCode");
        if (_errorCodeNode == null) {
            throw new RuntimeException("DescribeClusterResponseData: unable to locate field 'errorCode', which is mandatory in version " + _version);
        } else {
            _object.errorCode = MessageUtil.jsonNodeToShort(_errorCodeNode, "DescribeClusterResponseData");
        }
        JsonNode _errorMessageNode = _node.get("errorMessage");
        if (_errorMessageNode == null) {
            throw new RuntimeException("DescribeClusterResponseData: unable to locate field 'errorMessage', which is mandatory in version " + _version);
        } else {
            if (_errorMessageNode.isNull()) {
                _object.errorMessage = null;
            } else {
                if (!_errorMessageNode.isTextual()) {
                    throw new RuntimeException("DescribeClusterResponseData expected a string type, but got " + _node.getNodeType());
                }
                _object.errorMessage = _errorMessageNode.asText();
            }
        }
        JsonNode _clusterIdNode = _node.get("clusterId");
        if (_clusterIdNode == null) {
            throw new RuntimeException("DescribeClusterResponseData: unable to locate field 'clusterId', which is mandatory in version " + _version);
        } else {
            if (!_clusterIdNode.isTextual()) {
                throw new RuntimeException("DescribeClusterResponseData expected a string type, but got " + _node.getNodeType());
            }
            _object.clusterId = _clusterIdNode.asText();
        }
        JsonNode _controllerIdNode = _node.get("controllerId");
        if (_controllerIdNode == null) {
            throw new RuntimeException("DescribeClusterResponseData: unable to locate field 'controllerId', which is mandatory in version " + _version);
        } else {
            _object.controllerId = MessageUtil.jsonNodeToInt(_controllerIdNode, "DescribeClusterResponseData");
        }
        JsonNode _brokersNode = _node.get("brokers");
        if (_brokersNode == null) {
            throw new RuntimeException("DescribeClusterResponseData: unable to locate field 'brokers', which is mandatory in version " + _version);
        } else {
            if (!_brokersNode.isArray()) {
                throw new RuntimeException("DescribeClusterResponseData expected a JSON array, but got " + _node.getNodeType());
            }
            DescribeClusterBrokerCollection _collection = new DescribeClusterBrokerCollection(_brokersNode.size());
            _object.brokers = _collection;
            for (JsonNode _element : _brokersNode) {
                _collection.add(DescribeClusterBrokerJsonConverter.read(_element, _version));
            }
        }
        JsonNode _clusterAuthorizedOperationsNode = _node.get("clusterAuthorizedOperations");
        if (_clusterAuthorizedOperationsNode == null) {
            throw new RuntimeException("DescribeClusterResponseData: unable to locate field 'clusterAuthorizedOperations', which is mandatory in version " + _version);
        } else {
            _object.clusterAuthorizedOperations = MessageUtil.jsonNodeToInt(_clusterAuthorizedOperationsNode, "DescribeClusterResponseData");
        }
        return _object;
    }
    public static JsonNode write(DescribeClusterResponseData _object, short _version, boolean _serializeRecords) {
        ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
        _node.set("throttleTimeMs", new IntNode(_object.throttleTimeMs));
        _node.set("errorCode", new ShortNode(_object.errorCode));
        if (_object.errorMessage == null) {
            _node.set("errorMessage", NullNode.instance);
        } else {
            _node.set("errorMessage", new TextNode(_object.errorMessage));
        }
        _node.set("clusterId", new TextNode(_object.clusterId));
        _node.set("controllerId", new IntNode(_object.controllerId));
        ArrayNode _brokersArray = new ArrayNode(JsonNodeFactory.instance);
        for (DescribeClusterBroker _element : _object.brokers) {
            _brokersArray.add(DescribeClusterBrokerJsonConverter.write(_element, _version, _serializeRecords));
        }
        _node.set("brokers", _brokersArray);
        _node.set("clusterAuthorizedOperations", new IntNode(_object.clusterAuthorizedOperations));
        return _node;
    }
    public static JsonNode write(DescribeClusterResponseData _object, short _version) {
        return write(_object, _version, true);
    }
    
    public static class DescribeClusterBrokerJsonConverter {
        public static DescribeClusterBroker read(JsonNode _node, short _version) {
            DescribeClusterBroker _object = new DescribeClusterBroker();
            JsonNode _brokerIdNode = _node.get("brokerId");
            if (_brokerIdNode == null) {
                throw new RuntimeException("DescribeClusterBroker: unable to locate field 'brokerId', which is mandatory in version " + _version);
            } else {
                _object.brokerId = MessageUtil.jsonNodeToInt(_brokerIdNode, "DescribeClusterBroker");
            }
            JsonNode _hostNode = _node.get("host");
            if (_hostNode == null) {
                throw new RuntimeException("DescribeClusterBroker: unable to locate field 'host', which is mandatory in version " + _version);
            } else {
                if (!_hostNode.isTextual()) {
                    throw new RuntimeException("DescribeClusterBroker expected a string type, but got " + _node.getNodeType());
                }
                _object.host = _hostNode.asText();
            }
            JsonNode _portNode = _node.get("port");
            if (_portNode == null) {
                throw new RuntimeException("DescribeClusterBroker: unable to locate field 'port', which is mandatory in version " + _version);
            } else {
                _object.port = MessageUtil.jsonNodeToInt(_portNode, "DescribeClusterBroker");
            }
            JsonNode _rackNode = _node.get("rack");
            if (_rackNode == null) {
                throw new RuntimeException("DescribeClusterBroker: unable to locate field 'rack', which is mandatory in version " + _version);
            } else {
                if (_rackNode.isNull()) {
                    _object.rack = null;
                } else {
                    if (!_rackNode.isTextual()) {
                        throw new RuntimeException("DescribeClusterBroker expected a string type, but got " + _node.getNodeType());
                    }
                    _object.rack = _rackNode.asText();
                }
            }
            return _object;
        }
        public static JsonNode write(DescribeClusterBroker _object, short _version, boolean _serializeRecords) {
            ObjectNode _node = new ObjectNode(JsonNodeFactory.instance);
            _node.set("brokerId", new IntNode(_object.brokerId));
            _node.set("host", new TextNode(_object.host));
            _node.set("port", new IntNode(_object.port));
            if (_object.rack == null) {
                _node.set("rack", NullNode.instance);
            } else {
                _node.set("rack", new TextNode(_object.rack));
            }
            return _node;
        }
        public static JsonNode write(DescribeClusterBroker _object, short _version) {
            return write(_object, _version, true);
        }
    }
}
