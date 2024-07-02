/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.extract.base.metrics;

import org.apache.dolphinscheduler.common.utils.NetUtils;
import org.apache.dolphinscheduler.extract.base.SyncRequestDto;
import org.apache.dolphinscheduler.extract.base.protocal.Transporter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientSyncDurationMetrics {

    private Transporter transporter;

    private long milliseconds;

    @Builder.Default
    private String clientHost = NetUtils.getHost();

    private String serverHost;

    public static ClientSyncDurationMetrics of(SyncRequestDto syncRequestDto) {
        return ClientSyncDurationMetrics.builder()
                .transporter(syncRequestDto.getTransporter())
                .serverHost(syncRequestDto.getServerHost().getIp())
                .build();
    }

    public ClientSyncDurationMetrics withMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
        return this;
    }

}
