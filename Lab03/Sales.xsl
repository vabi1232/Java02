<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>


    <xsl:template match="Name">
        <span bgcolor="red">NAME: </span>
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Age">
       <span>AGE: </span>
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Commission">
        <span>Your Commission is </span>
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>


    <xsl:template match="Name1">
        NAME:
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Age1">
        AGE:
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Commission1">
        Your Commission is
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>


    <xsl:template match="Name2">
        NAME:
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Age2">
        AGE:
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Commission2">
        Your Commission is
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>


    <xsl:template match="Name3">
        NAME:
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Age3">
        AGE:
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="Commission3">
        Your Commission is
        <xsl:value-of select="."/>
        <br/>
    </xsl:template>


</xsl:stylesheet>