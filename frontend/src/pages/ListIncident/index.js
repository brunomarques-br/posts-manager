import React from 'react';
import { Link } from 'react-router-dom';
import { FiPower } from 'react-icons/fi';

import './styles.css';

export default function ListIncident() {
    return (
        <div className="profile-container">
            <header>
                <span>Bem vindo (a), Bruno Marques</span>

                <Link className="button" to="/incident/new" title="Cadastrar novo incidente">Cadastrar novo incidente </Link>

                <button onClick={() => { }} type="button" title="Sair">
                    <FiPower size={18} color="#164f78" />
                </button>
            </header>

            <h1>Incidentes Cadastrados</h1>

            <ul>
                <li>
                    <strong>Incidente: </strong>
                    <p>--</p>

                    <strong>Descrição: </strong>
                    <p>--</p>

                    <strong>Data: </strong>
                    <p>--</p>
                </li>

                <li>
                    <strong>Incidente: </strong>
                    <p>--</p>

                    <strong>Descrição: </strong>
                    <p>--</p>

                    <strong>Data: </strong>
                    <p>--</p>
                </li>

                <li>
                    <strong>Incidente: </strong>
                    <p>--</p>

                    <strong>Descrição: </strong>
                    <p>--</p>

                    <strong>Data: </strong>
                    <p>--</p>
                </li>

                <li>
                    <strong>Incidente: </strong>
                    <p>--</p>

                    <strong>Descrição: </strong>
                    <p>--</p>

                    <strong>Data: </strong>
                    <p>--</p>
                </li>
            </ul>

        </div>
    );
}