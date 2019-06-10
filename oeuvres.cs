using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Android_motstordus
{
    #region Oeuvres
    public class Oeuvres
    {
        #region Member Variables
        protected int _id_oeuvres;
        protected string _titre_oeuvres;
        protected string _auteur_oeuvres;
        protected string _ref_oeuvres;
        protected string _codeimage_oeuvres;
        #endregion
        #region Constructors
        public Oeuvres() { }
        public Oeuvres(string titre_oeuvres, string auteur_oeuvres, string ref_oeuvres, string codeimage_oeuvres)
        {
            this._titre_oeuvres=titre_oeuvres;
            this._auteur_oeuvres=auteur_oeuvres;
            this._ref_oeuvres=ref_oeuvres;
            this._codeimage_oeuvres=codeimage_oeuvres;
        }
        #endregion
        #region Public Properties
        public virtual int Id_oeuvres
        {
            get {return _id_oeuvres;}
            set {_id_oeuvres=value;}
        }
        public virtual string Titre_oeuvres
        {
            get {return _titre_oeuvres;}
            set {_titre_oeuvres=value;}
        }
        public virtual string Auteur_oeuvres
        {
            get {return _auteur_oeuvres;}
            set {_auteur_oeuvres=value;}
        }
        public virtual string Ref_oeuvres
        {
            get {return _ref_oeuvres;}
            set {_ref_oeuvres=value;}
        }
        public virtual string Codeimage_oeuvres
        {
            get {return _codeimage_oeuvres;}
            set {_codeimage_oeuvres=value;}
        }
        #endregion
    }
    #endregion
}