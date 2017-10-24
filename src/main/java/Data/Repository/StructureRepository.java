package Data.Repository;

import Data.DataContext;
import Data.SqlParameter;
import Entities.*;

import java.util.List;

public class StructureRepository {

    public List<ConstructionSiteEntity> GetAllConstructionSites()
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetAllConstructionSites", ConstructionSiteEntity.class);
        }
    }

    public List<PCTerritoryFlagEntity> GetAllTerritoryFlags()
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetAllTerritoryFlags", PCTerritoryFlagEntity.class);
        }
    }

    public PCTerritoryFlagEntity GetPCTerritoryFlagByID(int pcTerritoryFlagID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLSingle("Structure/GetPCTerritoryFlagByID", PCTerritoryFlagEntity.class,
                    new SqlParameter("pcTerritoryFlagID", pcTerritoryFlagID));
        }
    }

    public ConstructionSiteEntity GetConstructionSiteByID(int constructionSiteID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLSingle("Structure/GetConstructionSiteByID", ConstructionSiteEntity.class,
                    new SqlParameter("constructionSiteID", constructionSiteID));
        }
    }

    public PCTerritoryFlagStructureEntity GetPCStructureByID(int territoryFlagStructureID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLSingle("Structure/GetPCStructureByID", PCTerritoryFlagStructureEntity.class,
                    new SqlParameter("pcTerritoryFlagStructureID", territoryFlagStructureID));
        }
    }

    public StructureBlueprintEntity GetStructureBlueprintByID(int structureID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLSingle("Structure/GetStructureBlueprintByID", StructureBlueprintEntity.class,
                    new SqlParameter("structureBlueprintID", structureID));
        }
    }

    public List<StructureCategoryEntity> GetStructureCategoriesByType(boolean isTerritoryFlagCategory)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetStructureCategoriesByType", StructureCategoryEntity.class,
                    new SqlParameter("isTerritoryFlagCategory", isTerritoryFlagCategory));
        }
    }

    public List<StructureBlueprintEntity> GetStructuresByCategoryID(int categoryID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetStructuresByCategoryID", StructureBlueprintEntity.class,
                    new SqlParameter("structureCategoryID", categoryID));
        }
    }

    public List<PCTerritoryFlagPermissionEntity> GetPermissionsByFlagID(int flagID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetPermissionsByFlagID", PCTerritoryFlagPermissionEntity.class,
                    new SqlParameter("flagID", flagID));
        }
    }

    public List<PCTerritoryFlagPermissionEntity> GetPermissionsByPlayerID(String playerID, int flagID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetPermissionsByPlayerID", PCTerritoryFlagPermissionEntity.class,
                    new SqlParameter("flagID", flagID),
                    new SqlParameter("playerID", playerID));
        }
    }

    public PCTerritoryFlagPermissionEntity GetPermissionByID(String playerID, int permissionID, int flagID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLSingle("Structure/GetPermissionByID", PCTerritoryFlagPermissionEntity.class,
                    new SqlParameter("flagID", flagID),
                    new SqlParameter("playerID", playerID),
                    new SqlParameter("permissionID", permissionID));
        }
    }

    public List<TerritoryFlagPermissionEntity> GetAllTerritorySelectablePermissions()
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetAllTerritorySelectablePermissions", TerritoryFlagPermissionEntity.class);
        }
    }

    public TerritoryFlagPermissionEntity GetTerritoryPermissionByID(int territoryPermissionID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLSingle("Structure/GetTerritoryPermissionByID", TerritoryFlagPermissionEntity.class,
                    new SqlParameter("permissionID", territoryPermissionID));
        }
    }

    public int GetNumberOfStructuresInTerritory(int flagID)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLSingle("Structure/GetNumberOfStructuresInTerritory",
                    new SqlParameter("flagID", flagID));
        }
    }

    public List<PCTerritoryFlagEntity> GetAllFlagsInArea(String areaTag)
    {
        try(DataContext context = new DataContext())
        {
            return context.executeSQLList("Structure/GetAllFlagsInArea", PCTerritoryFlagEntity.class,
                    new SqlParameter("areaTag", areaTag));
        }
    }


    public void Save(Object entity)
    {
        try(DataContext context = new DataContext())
        {
            context.getSession().saveOrUpdate(entity);
        }
    }

    public void Delete(Object entity)
    {
        try(DataContext context = new DataContext())
        {
            context.getSession().delete(entity);
        }
    }

}
