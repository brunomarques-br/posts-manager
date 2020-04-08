import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft } from 'react-icons/fi';
import DatePicker, { registerLocale } from "react-datepicker";

import ptBR from 'date-fns/locale/pt-BR';

import "react-datepicker/dist/react-datepicker.css";

import './styles.css';

registerLocale('pt-BR', ptBR);

export default function Incident() {

    const [startDate, setStartDate] = useState(new Date());

    return (
        <div className="new-incident-container">
            <div className="content">
                <section>
                    <h1>Cadastrar novo incidente</h1>
                    <p>Descreva detalhadamente</p>

                    <Link className="back-link" to="/incident/list">
                        <FiArrowLeft size={16} color="#164f78" /> Voltar para home
                    </Link>
                </section>

                <form onSubmit={() => { }}>
                    <input placeholder="Título" required />

                    <textarea placeholder="Descrição" required />

                    <DatePicker
                        className="dataOcorrencia"
                        placeholder="Data da ocorrência"
                        selected={startDate}
                        onChange={date => setStartDate(date)}
                        locale="pt-BR"
                        dateFormat="d 'de' MMMM, yyyy"
                        required
                    />

                    <button className="button" type="submit" >Cadastrar</button>
                </form>
            </div>
        </div>
    );
}