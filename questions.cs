using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Android_motstordus
{
    #region Questions
    public class Questions
    {
        #region Member Variables
        protected int _id_questions;
        protected string _libelle_questions;
        protected string _choix_questions;
        protected string _choix_questions;
        protected string _choix_questions;
        protected string _solution_questions;
        protected string _libellecategorie_questions;
        protected string _indice_questions;
        #endregion
        #region Constructors
        public Questions() { }
        public Questions(string libelle_questions, string choix_questions, string choix_questions, string choix_questions, string solution_questions, string libellecategorie_questions, string indice_questions)
        {
            this._libelle_questions=libelle_questions;
            this._choix_questions=choix_questions;
            this._choix_questions=choix_questions;
            this._choix_questions=choix_questions;
            this._solution_questions=solution_questions;
            this._libellecategorie_questions=libellecategorie_questions;
            this._indice_questions=indice_questions;
        }
        #endregion
        #region Public Properties
        public virtual int Id_questions
        {
            get {return _id_questions;}
            set {_id_questions=value;}
        }
        public virtual string Libelle_questions
        {
            get {return _libelle_questions;}
            set {_libelle_questions=value;}
        }
        public virtual string Choix_questions
        {
            get {return _choix_questions;}
            set {_choix_questions=value;}
        }
        public virtual string Choix_questions
        {
            get {return _choix_questions;}
            set {_choix_questions=value;}
        }
        public virtual string Choix_questions
        {
            get {return _choix_questions;}
            set {_choix_questions=value;}
        }
        public virtual string Solution_questions
        {
            get {return _solution_questions;}
            set {_solution_questions=value;}
        }
        public virtual string Libellecategorie_questions
        {
            get {return _libellecategorie_questions;}
            set {_libellecategorie_questions=value;}
        }
        public virtual string Indice_questions
        {
            get {return _indice_questions;}
            set {_indice_questions=value;}
        }
        #endregion
    }
    #endregion
}