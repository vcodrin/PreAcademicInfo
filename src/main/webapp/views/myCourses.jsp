<%@include file="header.jsp" %>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <div class="mx-auto">
            <ul class="nav nav-tabs nav-justified">
                <li class="active"><a data-toggle="tab" href="#type">Proiect Colectiv</a></li>
                <li><a data-toggle="tab" href="#type">Limbaje formale si tehnici de compilare</a></li>
                <li><a data-toggle="tab" href="#type">Programare paralela si distribuita</a></li>
                <li><a data-toggle="tab" href="#type">Programare pentru mobile</a></li>
            </ul>
            <ul class="nav nav-tabs nav-justified" id="type">
                <li><a data-toggle="tab" href="#pc">Laborator</a></li>
                <li><a data-toggle="tab" href="#lftc">Seminar</a></li>
                <li><a data-toggle="tab" href="#ppd">Curs</a></li>
            </ul>

            <div class="tab-content">
                <div id="pc" class="tab-pane fade">
                    <table>
                        <div class="container-fluid">
                            <table class="table table-hover text-centered" style="margin: 0 auto">
                                <thead>
                                <tr>
                                    <th colspan="2" style="text-align: center">L1</th>
                                    <th colspan="2" style="text-align: center">L2</th>
                                    <th colspan="2" style="text-align: center">L3</th>
                                    <th colspan="2" style="text-align: center">L4</th>
                                    <th colspan="2" style="text-align: center">L5</th>
                                    <th colspan="2" style="text-align: center">L6</th>
                                    <th colspan="2" style="text-align: center">L7</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td style="text-align: center">P</td>
                                    <td style="text-align: center">N</td>
                                    <td style="text-align: center">P</td>
                                    <td style="text-align: center">N</td>
                                    <td style="text-align: center">P</td>
                                    <td style="text-align: center">N</td>
                                    <td style="text-align: center">P</td>
                                    <td style="text-align: center">N</td>
                                    <td style="text-align: center">P</td>
                                    <td style="text-align: center">N</td>
                                    <td style="text-align: center">P</td>
                                    <td style="text-align: center">N</td>
                                    <td style="text-align: center">P</td>
                                    <td style="text-align: center">N</td>
                                </tr>
                                <tr>
                                    <td style="text-align: center">
                                        <input type="checkbox" checked disabled>
                                    </td>
                                    <td style="text-align: center"></td>
                                    <td style="text-align: center">
                                        <input type="checkbox" disabled>
                                    </td>
                                    <td style="text-align: center">10</td>
                                    <td style="text-align: center">
                                        <input type="checkbox" checked disabled>
                                    </td>
                                    <td style="text-align: center">10</td>
                                    <td style="text-align: center">
                                        <input type="checkbox" checked disabled>
                                    </td>
                                    <td style="text-align: center">10</td>
                                    <td style="text-align: center">
                                        <input type="checkbox" checked disabled>
                                    </td>
                                    <td style="text-align: center">10</td>
                                    <td style="text-align: center">
                                        <input type="checkbox" checked disabled>
                                    </td>
                                    <td style="text-align: center">10</td>
                                    <td style="text-align: center">
                                        <input type="checkbox" checked disabled>
                                    </td>
                                    <td style="text-align: center">10</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </table>
                </div>
                <div id="lftc" class="tab-pane fade">
                </div>
                <div id="ppd" class="tab-pane fade">
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>