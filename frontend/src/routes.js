import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';

import Login from './pages/Login';
import Register from './pages/Register';
import Incident from './pages/Incident';
import DetailIncident from './pages/DetailIncident';

export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route exact path="/" component={Login} />
                <Route path="/register" component={Register} />
                <Route path="/incident/new" component={Incident} />
                <Route path="/incident/detail" component={DetailIncident} />
            </Switch>
        </BrowserRouter>
    );
}

