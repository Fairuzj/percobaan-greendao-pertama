package com.example.ok.percobaan1;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Padi {

    @Id
    private Long id;
    private int luaslahan;
    private String tgl_tanam;
    private String tgl_siappanen;
    private String hasilpanen;
    private String pemilik;
    private int nik;
    private int pekerja;
    @Generated(hash = 792030038)
    public Padi(Long id, int luaslahan, String tgl_tanam, String tgl_siappanen,
            String hasilpanen, String pemilik, int nik, int pekerja) {
        this.id = id;
        this.luaslahan = luaslahan;
        this.tgl_tanam = tgl_tanam;
        this.tgl_siappanen = tgl_siappanen;
        this.hasilpanen = hasilpanen;
        this.pemilik = pemilik;
        this.nik = nik;
        this.pekerja = pekerja;
    }
    @Generated(hash = 434793966)
    public Padi() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getLuaslahan() {
        return this.luaslahan;
    }
    public void setLuaslahan(int luaslahan) {
        this.luaslahan = luaslahan;
    }
    public String getTgl_tanam() {
        return this.tgl_tanam;
    }
    public void setTgl_tanam(String tgl_tanam) {
        this.tgl_tanam = tgl_tanam;
    }
    public String getTgl_siappanen() {
        return this.tgl_siappanen;
    }
    public void setTgl_siappanen(String tgl_siappanen) {
        this.tgl_siappanen = tgl_siappanen;
    }
    public String getHasilpanen() {
        return this.hasilpanen;
    }
    public String setHasilpanen(String hasilpanen) {
        this.hasilpanen = hasilpanen;
        return hasilpanen;
    }
    public String getPemilik() {
        return this.pemilik;
    }
    public String setPemilik(String pemilik) {
        this.pemilik = pemilik;
        return pemilik;
    }
    public int getNik() {
        return this.nik;
    }
    public void setNik(int nik) {
        this.nik = nik;
    }
    public int getPekerja() {
        return this.pekerja;
    }
    public void setPekerja(int pekerja) {
        this.pekerja = pekerja;
    }
}
