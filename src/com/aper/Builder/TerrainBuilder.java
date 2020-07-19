package com.aper.Builder;

public interface TerrainBuilder {
    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain Build();
}
